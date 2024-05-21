import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

const REST_HOME_API = `http://localhost:8080/ssafit`;

export const useHomeStore = defineStore("home", () => {
  const hotBoardList = ref([]);

  const getHotBoardList = function () {
    axios
      .get(`${REST_HOME_API}/board/popular`)
      .then((res) => {
        hotBoardList.value = res.data;
      })
      .catch((err) => {
        router.push({ name: "notFound" });
      });
  };

  return { hotBoardList, getHotBoardList };
});
