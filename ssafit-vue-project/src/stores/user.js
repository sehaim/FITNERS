import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

const REST_USER_API = `http://localhost:8080/ssafit`;

export const useUserStore = defineStore("user", () => {
  const loginUser = ref({
    userId: null,
    userName: null,
    isManager: false,
  });

  const setLoginUser = function (res) {
    loginUser.value.userId = res.data["userId"];
    loginUser.value.userName = res.data["userName"];
    loginUser.value.isManager = res.data["isManager"];
    localStorage.setItem("loginUser", JSON.stringify(loginUser.value));
  };

  const getLoginUser = ref(JSON.parse(localStorage.getItem("loginUser")));

  const loginErr = ref(false);
  const activeLoginErrClass = ref("");

  const login = function (user) {
    axios({
      url: REST_USER_API + "/login",
      method: "POST",
      data: user,
    })
      .then((res) => {
        sessionStorage.setItem("access-token", res.data["access-token"]);
        setLoginUser(res);
        getLoginUser.value = JSON.parse(localStorage.getItem("loginUser"));
        router.push({ name: "home" });
      })
      .catch(() => {
        loginErr.value = true;
        activeLoginErrClass.value = "alert-danger";
      });
  };

  const signupErr = ref(false);
  const activeSignupErrClass = ref("");

  const signup = function (user) {
    axios({
      url: REST_USER_API + "/signup",
      method: "POST",
      data: user,
    })
      .then(() => {
        router.push({ name: "login" });
      })
      .catch(() => {
        signupErr.value = true;
        activeSignupErrClass.value = "alert-danger";
      });
  };

  const logout = function () {
    axios({
      url: REST_USER_API + "/logout",
      method: "POST",
    })
      .then(() => {
        sessionStorage.clear();
        localStorage.clear();
        getLoginUser.value = JSON.parse(localStorage.getItem("loginUser"));
        router.push({ name: "home" });
        location.reload();
      })
      .catch(() => {
        router.push({ name: "notFound" });
      });
  };

  return {
    login,
    loginErr,
    activeLoginErrClass,
    loginUser,
    setLoginUser,
    getLoginUser,
    signup,
    signupErr,
    activeSignupErrClass,
    logout,
  };
});
