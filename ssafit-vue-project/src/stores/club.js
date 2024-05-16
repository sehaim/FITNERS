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

  const loginUser = ref(JSON.parse(localStorage.getItem("user")));
  const userId = ref(loginUser.value.loginUser.userId);

  const club = ref({
    clubName: null,
    clubDescription: null,
    userName: null,
  });
  const status = ref({});
  const clubSchedule = ref([]);

  const getClub = function (clubId) {
    if (userId.value !== null) {
      axios
        .get(`${REST_CLUB_API}/${clubId}&${userId}`)
        .then((res) => {
          club.value = res.data["club"];
          status.value = res.data["status"];
          if ((status.value = "COMPLETED")) {
            axios({
              url: REST_CLUB_API + "/`${clubId}`/detail",
              method: "POST",
              data: clubId,
            })
              .then((res) => {
                clubSchedule.value = res.data;
              })
              .catch((err) => {
                router.push({ name: "notFound" });
              });
          }
        })
        .catch((err) => {
          router.push({ name: "notFound" });
        });
    } else {
      router.push({ name: "login" });
    }
  };
  return { clubList, getClubList, club, getClub, userId, status, clubSchedule };
});
