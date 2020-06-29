<template>
  <div id="app">
    <div v-if="!isMobile">
      <NavBar></NavBar>
    </div>
    <div v-else>
      <MobileNavBar></MobileNavBar>
    </div>
    <div class="jumbotron">
      <b-jumbotron>
      </b-jumbotron>
    </div>
    <b-container fluid>
      <b-row>
        <b-col sm="2">
          <SideBar v-if="!isMobile"></SideBar>
        </b-col>
        <b-col sm="10">
          <router-view/>
        </b-col>
      </b-row>
    </b-container>
    <Footer></Footer>
  </div>
</template>

<script>

import NavBar from '@/components/NavBar.vue'
import MobileNavBar from '@/components/MobileNavBar.vue'
import SideBar from '@/components/SideBar.vue'
import Footer from '@/components/Footer.vue'

export default {
  name: 'App',
  components: {
    SideBar,
    NavBar,
    Footer,
    MobileNavBar
  },
  data () {
    return {
      isMobile: false
    }
  },
  created () {
    if (screen.width <= 760) {
      this.isMobile = true
    } else {
      this.isMobile = false
    }
  }
}
</script>
