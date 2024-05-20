<template>
  <div mypage-container>
    <div id="mypage-header">
      <div id="title">My Page</div>
    </div>
    <div id="mypage-content-container">
      <MyClub />
      <MySchedule v-if="!store.loginUser.isManager" />
      <MyMember v-else />
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import { useMypageStore } from "@/stores/mypage.js";
import MyClub from "./MyClub.vue";
import MySchedule from "./MySchedule.vue";
import MyMember from "./MyMember.vue";

const store = useMypageStore();

onMounted(() => {
  store.getUser();
});
</script>

<style scoped>
#mypage-header {
  height: 100px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  padding-right: 3%;
  padding-left: 3%;
  background: linear-gradient(
    to top,
    rgba(67, 85, 197, 0) 10%,
    rgba(67, 85, 197, 0.03) 30%,
    rgba(67, 85, 197, 0.06) 50%,
    rgba(67, 85, 197, 0.09) 75%,
    rgba(67, 85, 197, 0.1) 100%
  );
}

#title {
  font-size: 30px;
  color: rgb(54, 51, 51);
}

#mypage-content-container {
  display: flex;
  flex-direction: row;
  padding-left: 5%;
  padding-right: 5%;
}
</style>
