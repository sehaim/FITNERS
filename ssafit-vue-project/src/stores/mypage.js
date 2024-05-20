import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

const REST_MYPAGE_API = `http://localhost:8080/ssafit/mypage`;

export const useMypageStore = defineStore("mypage", () => {
  const loginUser = ref({});

  const getUser = function () {
    loginUser.value = JSON.parse(localStorage.getItem("loginUser"));
    if (loginUser.value !== null) {
      return true;
    } else {
      router.push({ name: "login" });
      return false;
    }
  };

  const myClubList = ref([]);

  const getMyClubList = function () {
    loginUser.value = JSON.parse(localStorage.getItem("loginUser"));
    axios
      .get(`${REST_MYPAGE_API}/${loginUser.value.userId}/club`)
      .then((res) => {
        myClubList.value = res.data["clubList"];
      })
      .catch(() => {
        router.push({ name: "notFound" });
      });
  };

  return { loginUser, getUser, myClubList, getMyClubList };
});
