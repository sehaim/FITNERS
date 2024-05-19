import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

const REST_MYPAGE_API = `http://localhost:8080/ssafit/mypage`;

export const useMypageStore = defineStore("mypage", () => {
  const user = ref({});
  const loginUser = ref({})

  const getUser = function() {
    user.value = JSON.parse(localStorage.getItem("user"));
    if(user.value != null) {
      if(user.value.loginUser.userId != null) {
        loginUser.value = user.value.loginUser
        return true;
      } else {
        router.push({ name: "login" });
        return false;
      }
    } else {
      router.push({ name: "login" });
      return false;
    }
  }

  const myClubList = ref([]);

  const getMyClubList = function () {
    axios.get(`${REST_MYPAGE_API}/${loginUser.value.userId}/club`)
    .then((res) => {
      myClubList.value = res.data["clubList"];
      console.log(myClubList.value)
    })
    .catch(() => {
      router.push({ name: "notFound" });
    })
  }


  return {user, loginUser, getUser, myClubList, getMyClubList};
}
,{persist: true})