<template>
  <div>
    <div id="club-detail-header">
      <div>Welcome {{ store.club.clubName }}</div>
      <div>{{ store.club.clubDescription }}</div>
    </div>
    <div id="club-detail-content">
      <ClubMemberNone v-if="store.status === 'NONE'" :clubId = "clubId"/>
      <ClubMemberProceeding v-if="store.status === 'PROCEEDING'" />
      <ClubSchedule v-if="store.status === 'COMPLETED'" />
      <ClubManagerNone v-if="store.status === 'MANAGER'" />
    </div>
  </div>
</template>

<script setup>
import { useClubStore } from "@/stores/club";
import { onMounted, ref } from "vue";
import { useRoute } from "vue-router";
import ClubMemberNone from "@/components/club/ClubMemberNone.vue";
import ClubMemberProceeding from "@/components/club/ClubMemberProceeding.vue";
import ClubSchedule from "@/components/club/ClubSchedule.vue";
import ClubManagerNone from "@/components/club/ClubManagerNone.vue";

const store = useClubStore();

const route = useRoute();

const clubId = ref(route.params.clubId)

onMounted(() => {
  store.getUser();
  store.getClub(clubId.value);
});
</script>

<style scoped>
#club-detail-header {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

#club-detail-content {
  display: flex;
  justify-content: center;
  margin: 3%;
}

</style>