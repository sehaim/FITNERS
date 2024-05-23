<template>
  <div id="club-manager-err-container">
    <img src="@/assets/img/gear-icon.png" alt="gear-icon" />
    <div id="content">클럽 관리자만 접근 가능합니다.</div>
  </div>
</template>

<style scoped>
#club-manager-err-container {
  width: 400px;
  height: 350px;
  padding: 5%;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
  padding: 8% 1%;
  border-radius: 10px;
  box-shadow: 0px 0px 3px 1px #8d8c8a;
  margin: 5% auto;
}

img {
  width: 50px;
  opacity: 70%;
}

#content {
  font-size: 18px;
}
</style>
