<template>
  <div id="club-schedule-manager-container">
    <div id="club-schedule-container-header">
      <div id="title">
        <img src="@/assets/img/schedule-icon.png" alt="schedule-icon">
        <div>Club Schedule</div>
      </div>
      <button @click="addSchedule">+</button>
      <ClubScheduleRegist v-if="isActive" @close-event="close"/>
    </div>
    <div id="club-schedule-list">
      <ClubScheduleItem v-for="clubSchedule in clubScheduleList" :key="clubSchedule.scheduleId" :clubSchedule="clubSchedule"/>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import ClubScheduleItem from './ClubScheduleItem.vue';
import ClubScheduleRegist from "./ClubScheduleRegist.vue";

const props = defineProps({
  clubScheduleList: Object
})

const isActive = ref(false)

const addSchedule = function() {
  isActive.value = true;
}

const close = function() {
  isActive.value = false;
}
</script>

<style scoped>
#club-schedule-manager-container {
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
  margin-bottom: 15px;
}

#club-schedule-list {
  width: 100%;
  height: 50vh;
  display: flex;
  flex-direction: column;
  overflow-y: scroll;
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