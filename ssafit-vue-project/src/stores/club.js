import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

const REST_CLUB_API = `http://localhost:8080/ssafit/club`;

export const useClubStore = defineStore("club", () => {

  
  const clubDetail = function () {
    axios({
      url: REST_CLUB_API,
      method: "GET",
    })
    .then((res) => {

    })
  }
  
  return {clubDetail}
})