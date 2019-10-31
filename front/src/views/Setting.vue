<template>
  <div class="settings">
    <v-container fluid>
      <v-row dense>
        <v-col cols="12" lg="3" md="4" sm="6" xs="12">
          <v-card hover link>
            <v-card-title>
              <div>
                <v-icon dense class="mr-2">mdi-application-import</v-icon>
                <span>수입 카테고리 설정</span>
              </div>
            </v-card-title>
            <v-card-subtitle>
              <div>수입 내역 카테고리를 관리합니다.</div>
            </v-card-subtitle>
          </v-card>
        </v-col>
        <v-col cols="12" lg="3" md="4" sm="6" xs="12">
          <v-card hover link>
            <v-card-title>
              <div>
                <v-icon dense class="mr-2">mdi-application-export</v-icon>
                <span>지출 카테고리 설정</span>
              </div>
            </v-card-title>
            <v-card-subtitle>
              <div>지출 내역 카테고리를 관리합니다.</div>
            </v-card-subtitle>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>
