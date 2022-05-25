<template>

<v-data-table
    :headers="headers"
    :items="topFood"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'TopFood',
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        headers: [
            { text: "id", value: "id" },
            { text: "fooid", value: "fooid" },
            { text: "count", value: "count" },
        ],
        topFood : [],
    }),
    async created() {
      var temp = await axios.get(axios.backend + '/topfoods')

      this.topFood = temp.data._embedded.topfoods;

    },
    methods: {
    }
  }
</script>


<function>