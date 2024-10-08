import { ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

const REST_CLUB_API = `http://localhost:8080/ssafit/club`;

export const useClubStore = defineStore(
  "club",
  () => {
    const clubList = ref([]);

    const getClubList = function () {
      axios({
        url: REST_CLUB_API,
        method: "GET",
      })
        .then((res) => {
          clubList.value = res.data;
        })
        .catch(() => {
          router.push({ name: "notFound" });
        });
    };

    const club = ref({});
    const status = ref({});
    const clubScheduleList = ref([]);

    const loginUser = ref({});

    const getClub = function (clubId) {
      loginUser.value = JSON.parse(localStorage.getItem("loginUser"));
      if (loginUser.value !== null) {
        clubList.value.forEach((el) => {
          if (el.clubId == clubId) {
            club.value = el;
          }
        });
        axios
          .get(`${REST_CLUB_API}/${clubId}/${loginUser.value.userId}`)
          .then((res) => {
            status.value = res.data;
            if (status.value === "COMPLETED") {
              axios({
                url: REST_CLUB_API + "/schedule",
                method: "POST",
                data: {
                  clubId: clubId,
                },
              })
                .then((res) => {
                  clubScheduleList.value = res.data;
                })
                .catch(() => {
                  router.push({ name: "notFound" });
                });
            } else {
              if (loginUser.value.isManager) {
                status.value = "MANAGER";
              }
            }
          })
          .catch(() => {
            router.push({ name: "notFound" });
          });
      } else {
        router.push({ name: "login" });
      }
    };

    const signupClub = function (clubId) {
      loginUser.value = JSON.parse(localStorage.getItem("loginUser"));
      axios({
        url: REST_CLUB_API + "/regist",
        method: "POST",
        data: {
          clubId: clubId,
          userId: loginUser.value.userId,
        },
      })
        .then(() => {
          status.value = "PROCEEDING";
        })
        .catch(() => {
          router.push({ name: "notFound" });
        });
    };

    const registSchedule = function (schedule) {
      axios({
        url: REST_CLUB_API + "/schedule/add",
        method: "POST",
        data: {
          clubId: club.value.clubId,
          schedule: schedule.value,
        },
      })
        .then(() => {
          location.reload();
        })
        .catch(() => {
          alert("이미 등록된 일정입니다.")
        });
    };

    const addIsActive = ref(false);

    const addMySchedule = function (clubId, schedule) {
      axios({
        url: REST_CLUB_API + "/user/schedule/add",
        method: "POST",
        data: {
          clubId: clubId,
          userId: loginUser.value.userId,
          schedule: schedule,
        },
      })
        .then(() => {
          addIsActive.value = true;
        })
        .catch(() => {
          alert("이미 등록된 일정입니다.")
        });
    };

    const close = function () {
      addIsActive.value = false;
    };

    const clubBoard = ref({});

    const getClubBoard = function (clubId) {
      loginUser.value = JSON.parse(localStorage.getItem("loginUser"));
      axios
        .get(`${REST_CLUB_API}/board/${clubId}`)
        .then((res) => {
          clubBoard.value = res.data;
        })
        .catch(() => {
          router.push({ name: "notFound" });
        });
    };

    const updateIsActive = ref(false);

    const update = function () {
      updateIsActive.value = true;
    };

    const updateClubBoard = function (clubId) {
      axios
        .put(REST_CLUB_API + "/board/" + `${clubId}`, clubBoard.value)
        .then(() => {
          updateIsActive.value = false;
          location.reload();
        })
        .catch(() => {
          router.push({ name: "notFound" });
        });
    };

    const deleteClubSchedule = function(scheduleId) {
      axios({
        url: REST_CLUB_API + "/schedule/" + `${scheduleId}`,
        method: 'DELETE'
      })
        .then(() => {
          location.reload();
        })
        .catch(() => {
          router.push({ name: "notFound" });
        });
    }

    return {
      clubList,
      getClubList,
      loginUser,
      club,
      getClub,
      status,
      clubScheduleList,
      signupClub,
      registSchedule,
      addMySchedule,
      addIsActive,
      close,
      clubBoard,
      getClubBoard,
      updateIsActive,
      update,
      updateClubBoard,
      deleteClubSchedule
    };
  },
  {
    persist: {
      enabled: true,
      strategies: [
        {
          storage: localStorage,
          paths: ["clubList"],
        },
      ],
    },
  }
);
