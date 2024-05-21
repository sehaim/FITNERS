<template>
  <div id="club-schedule-manager-item">
    <div id="date-time">
      <div id="date">
        <strong>{{ sliceDate(clubSchedule.schedule) }}</strong>
      </div>
      <div id="time">
        {{ sliceHour(clubSchedule.schedule) }}시
        {{ sliceMinute(clubSchedule.schedule) }}분
      </div>
    </div>
    <button @click="deleteClubSchedule">X</button>
  </div>
</template>

<script setup>
import { useClubStore } from "@/stores/club.js";

const store = useClubStore();

const props = defineProps({
  clubSchedule: Object,
});

const sliceDate = function (schedule) {
  return schedule.slice(0, 10);
};

const sliceHour = function (schedule) {
  return schedule.slice(11, 13);
};

const sliceMinute = function (schedule) {
  return schedule.slice(14, 16);
};

const deleteClubSchedule = function () {
  store.deleteClubSchedule(props.clubSchedule.scheduleId);
}
</script>

<style scoped>
#club-schedule-manager-item {
  height: 50px;
  min-height: 50px;
  width: 70%;
  min-width: 300px;
  max-width: 350px;
  display: flex;
  flex-direction: row;
  align-items: center;
  box-shadow: 0px 0px 3px 1px #799dbb;
  margin: 10px;
  border-radius: 10px;
  padding: 0 30px;
  justify-content: space-between;
}

#date-time {
  display: flex;
  flex-direction: row;
}

#time {
  margin-left: 30px;
}

button {
  border-style: none;
  background-color: transparent;
  font-size: 15px;
  color: #799dbb;
}
</style>
