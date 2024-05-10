import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

const REST_USER_API = `http://localhost:8080/ssafit`;

export const useUserStore = defineStore("user", () => {
  const login = function (user) {
    axios({
      url: REST_USER_API,
      method: "POST",
      data: user,
    })
      .then(() => {
        router.push({ name: "home" });
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const signup = function (user) {
    axios({
      url: REST_USER_API,
      method: "POST",
      data: user,
    })
      .then(() => {
        router.push({ name: login });
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const user = ref({});

  return { login, user, signup };
});
