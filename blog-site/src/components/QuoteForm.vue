<template>
  <div id="quote-form">
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group id="input-group-1" label="Quote:" label-for="input-1">
        <b-form-textarea
          id="input-1"
          v-model="form.quote"
          required
          placeholder="Enter quote"
          @input="setQuote"
          :value="form.quote"
        ></b-form-textarea>
      </b-form-group>

      <b-form-group id="input-group-2" label="Quote Author:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.author"
          required
          placeholder="Enter Author"
          @input="setAuthor"
          :value="form.author"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-3" label="Quote Source:" label-for="input-3">
        <b-form-input
          id="input-3"
          v-model="form.reference"
          placeholder="Enter Source Reference"
          @input="setSource"
          :value="form.reference"
        ></b-form-input>
      </b-form-group>

      <b-button-group>
        <b-button size="lg" variant="outline-secondary" type="submit">Submit</b-button>
        <b-button size="lg" variant="outline-secondary" type="reset">Reset</b-button>
      </b-button-group>
    </b-form>
    <br>
    <b-card>
      <blockquote class="blockquote mb-0">
        <p v-if="quote">"{{ quote }}"</p>
        <footer class="blockquote-footer" v-if="quoteAuthor">
          {{ quoteAuthor }} <cite v-if="quoteSource" title="Source Title">{{ quoteSource }}</cite>
        </footer>
      </blockquote>
    </b-card>
    
  </div>
</template>

<script>

import axios from 'axios'
import authHeader from '@/services/auth-header';

export default {
  name: 'QuoteForm',
  data () {
    return {
      data: {},
      form : {
        quote: '',
        author: '',
        reference: ''
      },
      quote: '',
      quoteAuthor: '',
      quoteSource: '',
      show: true
    }
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault()
      this.sendFormInfo()
      alert(JSON.stringify(this.form))
    },
    onReset(evt) {
      evt.preventDefault()
      // Reset our form values
      this.form.quote = ''
      this.form.author = ''
      this.form.reference = ''
      // Trick to reset/clear native browser form validation state
      this.show = false
      this.$nextTick(() => {
        this.show = true
      })
      this.quote = ''
      this.quoteSource = ''
      this.quoteAuthor = ''
    },
    sendFormInfo () {
      var baseUrl = process.env.VUE_APP_BASE_URL
      axios
        .post(baseUrl + '/addQuote', this.form, { headers: authHeader() })
        .then(response => {
          this.data = response.data
          console.log(this.data)
      })
    },
    setQuote: function () {
      this.quote = this.form.quote
    },
    setAuthor: function () {
      this.quoteAuthor = this.form.author
    },
    setSource: function () {
      this.quoteSource = this.form.reference
    }
  }
}
</script>
