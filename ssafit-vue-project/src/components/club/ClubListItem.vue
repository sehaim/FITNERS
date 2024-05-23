<template>
  <div id="club-list-item-container">
    <div>
      <RouterLink id="clubName" :to="`/club/${club.clubId}`">{{
        club.clubName
      }}</RouterLink>
    </div>
    <div id="main-img">
      <img src="@/assets/img/club-icon.png" alt="club-icon" />
      <div id="clubDescription">{{ club.clubDescription }}</div>
      <div id="userName">
        관리자 <strong>{{ club.userName }}</strong>
      </div>
    </div>
  </div>
</template>

<script setup>
defineProps({
  club: Object,
});
</script>

<style scoped>
#club-list-item-container {
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
  top: 5%;
}

#clubName {
  color: rgb(87, 86, 86);
  font-size: 23px;
  font-weight: 700;
}

#clubDescription {
  font-size: 17px;
  position: absolute;
  top: 25%;
}

#userName {
  text-align: right;
  font-size: 15px;
  position: absolute;
  bottom: -15%;
  right: 5%;
  color: rgb(87, 86, 86);
}

img {
  width: 195px;
  height: 170px;
  align-self: center;
  opacity: 10%;
}
</style>
