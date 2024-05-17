<template>
  <div>
    <ClubScheduleManager v-if="store.loginUser.isManager" />
    <ClubScheduleUser v-else />
  </div>
</template>

<script setup>
import { useClubStore } from "@/stores/club";
import ClubScheduleManager from './ClubScheduleManager.vue';
import ClubScheduleUser from './ClubScheduleUser.vue';

const store = useClubStore()

</script>