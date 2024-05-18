<template>
  <div id="club-schedule-container">
    <div id="title">Club Schedule</div>
    <div id="club-content">
      <div id="club-schedule-list">
        <ClubScheduleItem v-for="clubSchedule in clubScheduleList" :key="clubSchedule.scheduleId" :clubSchedule="clubSchedule"/>
      </div>
    </div>
    <div>
      <input type="datetime-local" v-model="schedule">
      <button @click="registSchedule">등록</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useClubStore } from "@/stores/club";
import ClubScheduleItem from './ClubScheduleItem.vue';

const store = useClubStore();

const props = defineProps({
  clubScheduleList: Object
})

const schedule = ref("")

const registSchedule = function() {
  store.registSchedule(schedule)
}

</script>

<style scoped>
#club-schedule-container {
  display: flex;
  flex-direction: row;
  padding: 3%;
}

#club-schedule-list {
  width: 700px;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
}
</style>