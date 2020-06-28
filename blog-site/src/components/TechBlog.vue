<template>
  <div id="tech-blog">
    <h2>{{ currPost.postTitle }}</h2>
    <p>{{ convertDate(currPost.postDate, 'full') }}</p>
    <div v-html="markedInput"></div>
  </div>
</template>

<script>

import marked from 'marked'
import dompurify from 'dompurify'

export default {
  name: 'TechBlog',
  props: {
    currPost : Object
  },
  data () {
    return {
    }
  },
  computed: {
    markedInput : function () {
      return dompurify.sanitize(marked(this.currPost.text))
    }
  }
}
</script>
