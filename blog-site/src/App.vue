<template>
  <div id="app">
    <NavBar></NavBar>
    <div class="jumbotron">
      <b-jumbotron>
      </b-jumbotron>
    </div>
    <b-container fluid>
      <b-row v-if="!isMobile">
        <b-col sm="2">
          <SideBar></SideBar>
        </b-col>
        <b-col sm="10">
          <router-view/>
        </b-col>
      </b-row>
      <b-row v-else>
        <b-col sm="12">
          <router-view/>
        </b-col>
      </b-row>
    </b-container>
    <Footer></Footer>
  </div>
</template>

<script>

import NavBar from '@/components/NavBar.vue'
import SideBar from '@/components/SideBar.vue'
import Footer from '@/components/Footer.vue'

export default {
  name: 'App',
  components: {
    SideBar,
    NavBar,
    Footer
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
