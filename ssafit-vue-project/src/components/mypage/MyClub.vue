<template>
  <div id="my-club-container">
    <div id="my-club-container-header">
      <div id="title">
        <img src="@/assets/img/myclub-icon.png" alt="myclub-icon" />
        <div>My Club</div>
      </div>
    </div>
    <hr />
    <MyClubList />
  </div>
</template>

<script setup>
import MyClubList from "@/components/mypage/MyClubList.vue";
</script>

<style scoped>
#my-club-container {
  height: 100%;
  min-height: 100%;
  width: 50%;
  min-width: 50%;
  padding: 20px;
  display: flex;
  flex-direction: column;
}

#my-club-container-header {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 15px;
}

#title {
  display: flex;
  flex-direction: row;
  align-items: center;
  font-size: 22px;
}

img {
  width: 40px;
  margin-right: 20px;
  opacity: 80%;
}

hr {
  width: 90%;
}
</style>
