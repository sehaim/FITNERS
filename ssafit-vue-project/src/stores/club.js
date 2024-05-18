import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

const REST_CLUB_API = `http://localhost:8080/ssafit/club`;

export const useClubStore = defineStore("club", () => {
  const clubList = ref([]);

  const getClubList = function () {
    axios({
      url: REST_CLUB_API,
      method: "GET",
    })
      .then((res) => {
        clubList.value = res.data;
      })
      .catch((err) => {
        router.push({ name: "notFound" });
      });
  };

  const user = ref({});
  const loginUser = ref({})

  const getUser = function() {
    user.value = JSON.parse(localStorage.getItem("user"));
    loginUser.value = user.value.loginUser
  }

  const club = ref({});
  const status = ref({});
  const clubScheduleList = ref([]);

  const getClub = function (clubId) {
    if (loginUser.value.userId !== null) {
      clubList.value.forEach((el) => {
        if(el.clubId == clubId) {
          club.value = el
        }
      })
      axios
        .get(`${REST_CLUB_API}/${clubId}&${loginUser.value.userId}`)
        .then((res) => {
          status.value = res.data["status"];
          // status.value = res.data
          if ((status.value === "COMPLETED")) {
            axios({
              url: REST_CLUB_API + "/" + `${clubId}` + "/schedule",
              method: "POST",
              data: clubId,
            })
              .then((res) => {
                clubScheduleList.value = res.data;
              })
              .catch((err) => {
                router.push({ name: "notFound" });
              });
          } else {
            if(loginUser.value.isManager) {
              status.value = "MANAGER"
            }
          }
        })
        .catch((err) => {
          router.push({ name: "notFound" });
        });
    } else {
      router.push({ name: "login" });
    }
  };

  const signupClub = function (clubId) {
    axios({
      url: REST_CLUB_API + "/" + `${clubId}` + "&" + `${loginUser.value.userId}` + "/regist",
      method: "POST",
      data: {
        clubId: clubId,
        userId: loginUser.value.userId
      }
    })
    .then(() => {
      status.value = "PROCEEDING"
    })
    .catch((err) => {
      router.push({ name: "notFound"})
    })
  };

  const registSchedule = function (schedule) {
    console.log(schedule.value)
  }


  return { clubList, getClubList, club, getClub, loginUser, getUser, status, clubScheduleList, signupClub, registSchedule };
},
{
  persist: {
    enabled: true,
    strategies: [{ storage: localStorage }],
  },
}
);
