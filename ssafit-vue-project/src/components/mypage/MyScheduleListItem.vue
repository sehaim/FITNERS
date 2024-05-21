<template>
  <div id="my-schedule-item-container" v-if="clubName == mySchedule.clubId">
    <div id="date-time">
      <div id="date">{{ sliceDate(mySchedule.schedule) }}</div>
      <div id="time">
        {{ sliceHour(mySchedule.schedule) }}시
        {{ sliceMinute(mySchedule.schedule) }}분
      </div>
    </div>
    <button @click="deleteMySchedule">X</button>
  </div>
</template>

<script setup>
import { useMypageStore } from "@/stores/mypage.js";

const props = defineProps({
  clubName: String,
  mySchedule: Object,
  loginUser: Object
});

const store = useMypageStore();

const sliceDate = function (schedule) {
  return schedule.slice(0, 10);
};

const sliceHour = function (schedule) {
  return schedule.slice(11, 13);
};

const sliceMinute = function (schedule) {
  return schedule.slice(14, 16);
};

const deleteMySchedule = function () {
  store.deleteMySchedule(props.loginUser.userId, props.mySchedule.scheduleId)
}
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
  justify-content: space-between;
}

#date-time {
  display: flex;
  flex-direction: row;
  align-items: center;
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
