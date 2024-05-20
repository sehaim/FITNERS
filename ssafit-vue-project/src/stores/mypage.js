import { ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

const REST_MYPAGE_API = `http://localhost:8080/ssafit/mypage`;

export const useMypageStore = defineStore("mypage", () => {
  const loginUser = ref(null);
  const isMypageActive = ref(false);

  const getUser = function () {
    loginUser.value = JSON.parse(localStorage.getItem("loginUser"));
    if (loginUser.value === null) {
      router.push({ name: "login" });
      isMypageActive.value = false;
    } else {
      isMypageActive.value = true;
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

  const myScheduleList = ref([]);

  const getMyScheduleList = function () {
    loginUser.value = JSON.parse(localStorage.getItem("loginUser"));
    axios
      .get(`${REST_MYPAGE_API}/user/${loginUser.value.userId}/schedule`)
      .then((res) => {
        myScheduleList.value = res.data["scheduleList"];
      })
      .catch(() => {
        router.push({ name: "notFound" });
      });
  };

  const memberRegistList = ref([]);

  const getMemberRegistList = function () {
    loginUser.value = JSON.parse(localStorage.getItem("loginUser"));
    axios
      .get(`${REST_MYPAGE_API}/manager/${loginUser.value.userId}/registList`)
      .then((res) => {
        memberRegistList.value = res.data["clubRegistList"];
      })
      .catch(() => {
        router.push({ name: "notFound" });
      });
  };

  const registMember = function (userId, clubId) {
    axios({
      url: REST_MYPAGE_API + "/manager/member/accepted",
      method: "POST",
      data: {
        clubId: clubId,
        userId: userId,
      },
    })
      .then(() => {
        location.reload();
      })
      .catch(() => {
        router.push({ name: "notFound" });
      });
  };

  const declineMember = function (userId, clubId) {
    axios({
      url: REST_MYPAGE_API + "/manager/member/denied",
      method: "POST",
      data: {
        clubId: clubId,
        userId: userId,
      },
    })
      .then(() => {
        location.reload();
      })
      .catch(() => {
        router.push({ name: "notFound" });
      });
  };

  return {
    loginUser,
    getUser,
    myClubList,
    getMyClubList,
    myScheduleList,
    getMyScheduleList,
    isMypageActive,
    memberRegistList,
    getMemberRegistList,
    registMember,
    declineMember,
  };
});
