<template>
  <div id="club-schedule-user-container">
    <div id="club-schedule-container-header">
      <div id="title">
        <img src="@/assets/img/schedule-icon.png" alt="schedule-icon" />
        <div>Club Schedule</div>
      </div>
    </div>
    <div id="club-schedule-list">
      <ClubScheduleUserItem
        v-for="clubSchedule in clubScheduleList"
        :key="clubSchedule.scheduleId"
        :clubSchedule="clubSchedule"
      />
    </div>
  </div>
</template>

<script setup>
import ClubScheduleUserItem from "./ClubScheduleUserItem.vue";

const props = defineProps({
  clubScheduleList: Object,
});
</script>

<style scoped>
#club-schedule-user-container {
  width: 100%;
  min-width: 100%;
  height: 100%;
  min-height: 100%;
  display: flex;
  flex-direction: column;
}

#club-schedule-container-header {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  width: 100%;
  margin-bottom: 15px;
}

#club-schedule-list {
  width: 100%;
  height: 50vh;
  display: flex;
  flex-direction: column;
  overflow-y: scroll;
}

#club-schedule-list::-webkit-scrollbar {
  display: none;
}

#title {
  display: flex;
  flex-direction: row;
  align-items: center;
  font-size: 22px;
}

button {
  width: 60px;
  border-style: none;
  font-size: 20px;
  border-radius: 10px;
  background-color: #ffdc5cc3;
  color: white;
  margin-right: 10px;
}

img {
  width: 40px;
  margin-right: 20px;
}
</style>
