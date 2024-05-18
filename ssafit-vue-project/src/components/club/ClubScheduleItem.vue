<template>
  <div id="club-schedule-item">
    <div id="date">{{ sliceDate(clubSchedule.schedule) }}</div>
    <div id="time">{{ sliceHour(clubSchedule.schedule) }}시 {{ sliceMinute(clubSchedule.schedule) }}분</div>
  </div>
</template>

<script setup>
const props = defineProps({
  clubSchedule: Object
})

const sliceDate = function (schedule) {
  return schedule.slice(0, 10);
}

const sliceHour = function (schedule) {
  return schedule.slice(12, 13);
}

const sliceMinute = function (schedule) {
  return schedule.slice(15,16);
}
</script>

<style scoped>
#club-schedule-item {
  height: 50px;
  width: 250px;
  display: flex;
  flex-direction: row;
  align-items: center;
  box-shadow: 0px 0px 3px 1px #799dbb;
  margin: 20px;
  border-radius: 10px;
  padding: 0 20px;
}

#time {
  margin-left: 20px;
}
</style>