<template>
  <div id="club-schedule-regist-container">
    <button id="close-button" @click="$emit('closeEvent')">x</button>
    <input type="datetime-local" v-model="schedule" />
    <button id="regist-button" @click="registSchedule">등록</button>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useClubStore } from "@/stores/club";

const store = useClubStore();

const schedule = ref("");

const registSchedule = function () {
  store.registSchedule(schedule);
};
</script>

<style scoped>
#club-schedule-regist-container {
  width: 400px;
  height: 200px;
  display: flex;
  flex-direction: column;
  position: fixed;
  top: 50vh;
  left: 50vw;
  transform: translate(-50%, -50%);
  background-color: white;
  align-items: center;
  justify-content: space-between;
  box-shadow: 0px 0.5px 2px 1px #cbcac8;
  border-radius: 5px;
  padding: 1%;
}

input {
  width: 220px;
  height: 30px;
  border-radius: 5px;
  border-color: #8d8c8a83;
  color: #8d8c8a;
}

#close-button {
  font-size: 20px;
  background-color: transparent;
  border-style: none;
  color: rgb(139, 137, 137);
  margin-left: 90%;
}

#regist-button {
  width: 60px;
  min-width: 60px;
  height: 30px;
  min-height: 30px;
  border-style: none;
  border-radius: 5px;
  margin-bottom: 10px;
  background-color: #ffdc5cc3;
  color: rgb(71, 69, 69);
  font-size: 14px;
}
</style>
