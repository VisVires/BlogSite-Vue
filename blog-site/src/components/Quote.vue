<template>
  <div id="quote" v-if="quote.quote">
    <b-card>
    <h5>Quote of the Week</h5>
      <blockquote class="blockquote mb-0">
        <p>"{{ quote.quote }}"</p>
        <footer class="blockquote-footer">
          {{ quote.author }} <cite v-if="quote.source" title="Source Title">Source Title</cite>
        </footer>
      </blockquote>
    </b-card>
  </div>
</template>

<script>

import axios from 'axios'

export default {
  name: 'Quote',
  data () {
    return {
      quote: {}
    }
  },
  created () {
    var baseUrl = process.env.VUE_APP_BASE_URL
    axios
      .get(baseUrl + '/quote')
      .then(response => {
        this.quote = response.data
      })
      .catch(error => console.log(error))
  }
}
</script>
