<template>
    <v-card outlined>
        <v-card-title>
            ReviewCreate
        </v-card-title>

        <v-card-text>
            <String label="ReviewContent" v-model="value.reviewContent" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="reviewCreate"
            >
                ReviewCreate
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'ReviewCreateCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.reviewContent = '';
        },
        watch: {
        },
        methods: {
            reviewCreate() {
                this.$emit('reviewCreate', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

