<template>

<v-card style="width:300px; margin-left:5%;" outlined>
    <template slot="progress">
      <v-progress-linear
        color="deep-purple"
        height="10"
        indeterminate
      ></v-progress-linear>
    </template>

    <v-img
      style="width:290px; height:150px; border-radius:10px; position:relative; margin-left:5px; top:5px;"
      src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
    ></v-img>

    <v-card-title v-if="value._links">
        StoreOrder # {{value._links.self.href.split("/")[value._links.self.href.split("/").length - 1]}}
    </v-card-title >
    <v-card-title v-else>
        StoreOrder
    </v-card-title >

    <v-card-text style = "margin-left:-15px; margin-top:10px;">

          <div class="grey--text ml-4" v-if="editMode" style = "margin-top:-20px;">
            <v-text-field label="FoodId" v-model="value.foodId"/>
          </div>
          <div class="grey--text ml-4" v-else>
            FoodId :  {{value.foodId }}
          </div>


          <div class="grey--text ml-4" v-if="editMode" style = "margin-top:-20px;">
            <v-text-field label="Preference" v-model="value.preference"/>
          </div>
          <div class="grey--text ml-4" v-else>
            Preference :  {{value.preference }}
          </div>


          <div class="grey--text ml-4" v-if="editMode" style = "margin-top:-20px;">
            <v-text-field type="number" label="OrderId" v-model="value.orderId"/>
          </div>
          <div class="grey--text ml-4" v-else>
            OrderId :  {{value.orderId }}
          </div>

          <div class="grey--text ml-4" v-if="editMode" style = "margin-top:-20px;">
            <v-text-field label="Status" v-model="value.status"/>
          </div>
          <div class="grey--text ml-4" v-else>
            Status :  {{value.status }}
          </div>


          <div class="grey--text ml-4" v-if="editMode" style = "margin-top:-20px;">
            <v-text-field label="Test" v-model="value.test"/>
          </div>
          <div class="grey--text ml-4" v-else>
            Test :  {{value.test }}
          </div>



    </v-card-text>

    <v-divider class="mx-4"></v-divider>

    <v-card-actions style = "position:absolute; right:0; bottom:0;">
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="edit"
        v-if="!editMode"
      >
        Edit
      </v-btn>
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="save"
        v-else
      >
        Save
      </v-btn>
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="remove"
        v-if="!editMode"
      >
        Delete
      </v-btn>
      
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="finishCook"
        v-if="!editMode"
      >
        FinishCook
      </v-btn>
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="accept"
        v-if="!editMode"
      >
        Accept
      </v-btn>
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="reject"
        v-if="!editMode"
      >
        Reject
      </v-btn>
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="startCook"
        v-if="!editMode"
      >
        StartCook
      </v-btn>
    </v-card-actions>
  </v-card>


</template>

<script>
  const axios = require('axios').default;
  
  
  
  
  
  
  export default {
    name: 'StoreOrder',
    components:{
    },
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        date: new Date().toISOString().substr(0, 10),
    }),
    created(){
    },

    methods: {
      edit(){
        this.editMode = true;
      },
      async save(){
        try{
          var temp = null;
          if(this.isNew){
            temp = await axios.post(axios.fixUrl('/storeOrders'), this.value)
          }else{
            temp = await axios.put(axios.fixUrl(this.value._links.self.href), this.value)
          }

          this.value = temp.data;

          this.editMode = false;
          this.$emit('input', this.value);

          if(this.isNew){
            this.$emit('add', this.value);
          }else{
            this.$emit('edit', this.value);
          }

        }catch(e){
          alert(e.message)
        }
      },
      async remove(){
        try{
          await axios.delete(axios.fixUrl(this.value._links.self.href))
          this.editMode = false;
          this.isDeleted = true;

          this.$emit('input', this.value);
          this.$emit('delete', this.value);

        }catch(e){
          alert(e.message)
        }
      },
      async finishCook(){
        try{
          var temp = await axios.put(axios.fixUrl(this.value._links.finishCook.href))
          this.value = temp.data;
          this.editMode = false;
        }catch(e){
          alert(e.message)
        }
      },
      
      async accept(){
        try{
          var temp = await axios.put(axios.fixUrl(this.value._links.accept.href))
          this.value = temp.data;
          this.editMode = false;
        }catch(e){
          alert(e.message)
        }
      },
      
      async reject(){
        try{
          var temp = await axios.put(axios.fixUrl(this.value._links.reject.href))
          this.value = temp.data;
          this.editMode = false;
        }catch(e){
          alert(e.message)
        }
      },
      
      async startCook(){
        try{
          var temp = await axios.put(axios.fixUrl(this.value._links.startCook.href))
          this.value = temp.data;
          this.editMode = false;
        }catch(e){
          alert(e.message)
        }
      },
      
    },
  }
</script>


<function>