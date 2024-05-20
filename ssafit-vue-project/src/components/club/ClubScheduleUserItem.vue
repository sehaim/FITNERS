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
    <button @click="addMySchedule">+</button>
    <ClubToMypage v-if="addIsActive" @close-event="close" />
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useClubStore } from "@/stores/club";
import ClubToMypage from "./ClubToMypage.vue";

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

const addIsActive = ref(false);

const addMySchedule = function () {
  store.addMySchedule(props.clubSchedule.clubId, props.clubSchedule.schedule);
  addIsActive.value = store.addIsActive;
};

const close = function () {
  addIsActive.value = false;
};
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
  justify-content: space-between;
  box-shadow: 0px 0px 3px 1px #799dbb;
  margin: 10px;
  border-radius: 10px;
  padding: 0 30px;
}

#date-time {
  display: flex;
  flex-direction: row;
  align-items: center;
  width: 70%;
  min-width: 200px;
  justify-content: space-between;
}

button {
  border-style: none;
  background-color: transparent;
  font-size: 30px;
  color: #799dbb;
}
</style>
