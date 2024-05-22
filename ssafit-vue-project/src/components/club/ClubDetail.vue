<template>
  <div id="club-detail-container">
    <div id="club-detail-header">
      <div id="club-welcome">
        Welcome &nbsp;&nbsp;<span id="club-name">{{
          store.club.clubName
        }}</span>
        &nbsp;!
      </div>
      <div id="club-description">{{ store.club.clubDescription }}</div>
      <div id="club-manager-name">
        관리자 &nbsp;&nbsp;<strong id="name">{{ store.club.userName }}</strong>
      </div>
    </div>
    <div id="club-detail-content">
      <ClubMemberNone v-if="store.status === 'NONE'" :clubId="clubId" />
      <ClubMemberProceeding v-if="store.status === 'PROCEEDING'" />
      <ClubMemberDetail
        id="club-member-detail"
        v-if="store.status === 'COMPLETED'"
        :clubId="clubId"
      />
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
import ClubManagerNone from "@/components/club/ClubManagerNone.vue";
import ClubMemberDetail from "./ClubMemberDetail.vue";

const store = useClubStore();

const route = useRoute();

const clubId = ref(route.params.clubId);

defineProps({
  clubId: Number,
  clubName: String,
  clubDescription: String,
  userId: String,
  userName: String,
});

onMounted(() => {
  store.addIsActive = false;
  store.updateIsActive = false;
  clubId.value = route.params.clubId;
  store.getClub(clubId.value);
  store.getClubBoard(clubId.value);
});
</script>

<style scoped>
#club-detail-header {
  height: 100px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  padding-right: 3%;
  padding-left: 3%;
  background: linear-gradient(
    to top,
    rgba(67, 85, 197, 0) 10%,
    rgba(67, 85, 197, 0.03) 30%,
    rgba(67, 85, 197, 0.06) 50%,
    rgba(67, 85, 197, 0.09) 75%,
    rgba(67, 85, 197, 0.1) 100%
  );
}

#club-detail-content {
  display: flex;
  flex-direction: column;
}

#club-welcome {
  font-size: 30px;
  color: gray;
}

#club-name {
  font-family: "neodgm";
  color: rgb(94, 91, 91);
  animation-duration: 3s;
  animation-name: fadeInDown;
}

@keyframes fadeInDown {
  0% {
    opacity: 0;
    transform: translate3d(0, -100%, 0);
  }
  to {
    opacity: 1;
    transform: translateZ(0);
  }
}

#club-description {
  font-size: 20px;
}

#club-manager-name {
  font-size: 15px;
}

#name {
  font-size: 17px;
}

#club-member-detail {
  display: flex;
  flex-direction: row;
  padding-left: 5%;
  padding-right: 5%;
}
</style>
