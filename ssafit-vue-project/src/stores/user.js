import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

const REST_USER_API = `http://localhost:8080/ssafit`;

export const useUserStore = defineStore("user", () => {
  const loginUser = ref({
    userId: "",
    userName: "",
  });

  const getUser = function () {
    loginUser.value.userId = sessionStorage.getItem("userId");
    loginUser.value.userName = sessionStorage.getItem("userName");
  };

  const login = function (user) {
    // sessionStorage.setItem("userId", user.id);
    // getUser();
    // router.push({ name: "home" });
    axios({
      url: REST_USER_API + "/login",
      method: "POST",
      data: user,
    })
      .then(() => {
        getUser();
        router.push({ name: "home" });
      })
      .catch((err) => {
        router.push({ name: "notFound" });
        console.log(err);
      });
  };

  const signup = function (user) {
    axios({
      url: REST_USER_API + "/signup",
      method: "POST",
      data: user,
    })
      .then(() => {
        router.push({ name: "login" }); 
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return { login, signup, loginUser, getUser };
});
