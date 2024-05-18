<template>
  <div>
    <div>스케줄 매니저</div>
    <div>
      <ClubScheduleItem v-for="clubSchedule in clubScheduleList" :key="clubSchedule.scheduleId" :clubSchedule="clubSchedule"/>
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

defineProps({
  clubScheduleList: Object
})

const schedule = ref("")

const registSchedule = function() {
  store.registSchedule(schedule)
}

</script>