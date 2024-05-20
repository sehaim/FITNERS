<template>
  <div id="my-schedule-list-container">
    <MyScheduleListByClub
      v-for="myClub in store.myClubList"
      :key="myClub.clubId"
      :myClub="myClub"
      :myScheduleList="store.myScheduleList"
    />
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useMypageStore } from "@/stores/mypage.js";
import MyScheduleListByClub from "./MyScheduleListByClub.vue";

const store = useMypageStore();

onMounted(() => {
  store.getMyClubList();
  store.getMyScheduleList();
});
</script>

<style scoped>
#my-schedule-list-container {
  height: 100%;
  width: 100%;
  display: flex;
  flex-direction: column;
  overflow-y: scroll;
}

#my-schedule-list-container::-webkit-scrollbar {
  display: none;
}
</style>
