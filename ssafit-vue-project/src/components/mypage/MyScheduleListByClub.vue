<template>
  <div id="my-schedule-list-by-club-container">
    <hr />
    <div id="club-name">{{ myClub.clubName }}</div>
    <MyScheduleListItem
      v-for="mySchedule in myScheduleList"
      :key="mySchedule.scheduleId"
      :clubName="myClub.clubName"
      :mySchedule="mySchedule"
    />
  </div>
</template>

<script setup>
import MyScheduleListItem from "./MyScheduleListItem.vue";

defineProps({
  myClub: Object,
  myScheduleList: Object,
});
</script>

<style scoped>
#my-schedule-list-by-club-container {
  display: flex;
  flex-direction: column;
  width: 90%;
}

#club-name {
  font-size: 20px;
  font-weight: 600;
  color: #276699;
  margin: 10px 0;
}

hr {
  width: 100%;
}
</style>
