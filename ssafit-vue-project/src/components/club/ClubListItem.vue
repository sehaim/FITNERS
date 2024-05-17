<template>
  <div id="container">
    <div>
      <RouterLink id="clubName" :to="`/club/${club.clubId}`">{{
        club.clubName
      }}</RouterLink>
    </div>
    <div id="main-img">
      <!-- <img src="@/assets/icon/club-item-icon.png" alt="" /> -->
      <div id="clubDescription">{{ club.clubDescription }}</div>
      <div id="userName">
        관리자 <strong>{{ club.userName }}</strong>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useClubStore } from "@/stores/club";

const store = useClubStore();

defineProps({
  club: Object,
});
</script>

<style scoped>
#container {
  display: flex;
  flex-direction: column;
  width: 230px;
  height: 280px;
  border-radius: 10px;
  padding: 15px;
  margin: 15px;
  box-shadow: 0px 0px 3px 1px #799dbb;
}

#main-img {
  position: relative;
}

#clubName {
  color: rgb(87, 86, 86);
  font-size: 23px;
  font-weight: 700;
}

#clubDescription {
  font-size: 17px;
  position: absolute;
  top: 20%;
}

#userName {
  text-align: right;
  font-size: 15px;
  position: absolute;
  bottom: 10%;
  right: 10%;
  color: rgb(87, 86, 86);
}

img {
  width: 210px;
  height: 225px;
  align-self: center;
  opacity: 20%;
}
</style>
