import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

const REST_CLUB_API = `http://localhost:8080/ssafit/club`;

export const useClubStore = defineStore("club", () => {
  const clubList = ref([
    {
      clubId: 1,
      clubName: "하이랙스 강남점",
      clubDescription:
        "RAX가 알려주는 맞춤 운동! 프리미엄 운동기구부터 쾌적한 시설까지!",
      userName: "임세하",
    },
    {
      clubId: 2,
      clubName: "Test",
      clubDescription: "Test",
      userName: "Test",
    },
    {
      clubId: 3,
      clubName: "Test",
      clubDescription: "Test",
      userName: "Test",
    },
    {
      clubId: 4,
      clubName: "Test",
      clubDescription: "Test",
      userName: "Test",
    },
  ]);

  const getClubList = function () {
    // axios({
    //   url: REST_CLUB_API,
    //   method: "GET",
    // })
    //   .then((res) => {
    //     clubList.value = res.data;
    //   })
    //   .catch((err) => {
    //     router.push({ name: "notFound" });
    //   });
  };

  const getClub = function () {};
  return { clubList, getClubList, getClub };
});
