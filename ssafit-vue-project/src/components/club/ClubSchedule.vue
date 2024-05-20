<template>
  <div id="club-schedule-container">
    <ClubScheduleManager
      v-if="store.loginUser.isManager"
      :clubScheduleList="store.clubScheduleList"
    />
    <ClubScheduleUser v-else :clubScheduleList="store.clubScheduleList" />
  </div>
</template>

<script setup>
import { useClubStore } from "@/stores/club";
import ClubScheduleManager from "./ClubScheduleManager.vue";
import ClubScheduleUser from "./ClubScheduleUser.vue";

const store = useClubStore();
</script>

<style scoped>
#club-schedule-container {
  height: 100%;
  min-height: 100%;
  width: 50%;
  min-width: 50%;
  padding: 20px;
}
</style>
