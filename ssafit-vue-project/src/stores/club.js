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

  const user = ref(JSON.parse(localStorage.getItem("user")));
  const loginUser = ref(user.value.loginUser)

  const club = ref({
    clubName: null,
    clubDescription: null,
    userName: null,
  });
  const status = ref({});
  const clubSchedule = ref([]);

  const getClub = function (clubId) {
    if (loginUser.value.userId !== null) {
      axios
        .get(`${REST_CLUB_API}/${clubId}&${loginUser.value.userId}`)
        .then((res) => {
          club.value = res.data["club"];
          status.value = res.data["status"];
          if ((status.value === "COMPLETED")) {
            axios({
              url: REST_CLUB_API + "/" + `${clubId}` + "/schedule",
              method: "POST",
              data: clubId,
            })
              .then((res) => {
                clubSchedule.value = res.data;
              })
              .catch((err) => {
                router.push({ name: "notFound" });
              });
          } else {
            if(loginUser.value.isManager) {
              router.push({name: "notFound"})
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


  return { clubList, getClubList, club, getClub, loginUser, status, clubSchedule, signupClub };
});
