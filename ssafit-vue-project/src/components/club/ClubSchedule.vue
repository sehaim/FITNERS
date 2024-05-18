<template>
  <div>
    <ClubScheduleManager v-if="store.loginUser.isManager" :clubScheduleList="store.clubScheduleList"/>
    <ClubScheduleUser v-else :clubScheduleList="store.clubScheduleList "/>
  </div>
</template>

<script setup>
import { useClubStore } from "@/stores/club";
import ClubScheduleManager from './ClubScheduleManager.vue';
import ClubScheduleUser from './ClubScheduleUser.vue';

const store = useClubStore()
</script>