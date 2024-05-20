<template>
  <div id="my-schedule-item-container" v-if="clubName == mySchedule.clubId">
    <div id="date">{{ sliceDate(mySchedule.schedule) }}</div>
    <div id="time">
      {{ sliceHour(mySchedule.schedule) }}시
      {{ sliceMinute(mySchedule.schedule) }}분
    </div>
  </div>
</template>

<script setup>
defineProps({
  clubName: String,
  mySchedule: Object,
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
</script>

<style scoped>
#my-schedule-item-container {
  display: flex;
  flex-direction: row;
  align-items: center;
  width: 70%;
  min-width: 300px;
  max-width: 350px;
  height: 40px;
  padding: 0 5%;
  background-color: rgba(199, 199, 199, 0.384);
  border-radius: 10px;
  margin: 7px 0;
}

#time {
  margin-left: 30px;
}
</style>
