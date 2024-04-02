
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderServiceOrderManager from "./components/listers/OrderServiceOrderCards"
import OrderServiceOrderDetail from "./components/listers/OrderServiceOrderDetail"

import DeliveryServiceDeliveryManager from "./components/listers/DeliveryServiceDeliveryCards"
import DeliveryServiceDeliveryDetail from "./components/listers/DeliveryServiceDeliveryDetail"

import ProductServiceProductManager from "./components/listers/ProductServiceProductCards"
import ProductServiceProductDetail from "./components/listers/ProductServiceProductDetail"

import ReviewServiceReviewManager from "./components/listers/ReviewServiceReviewCards"
import ReviewServiceReviewDetail from "./components/listers/ReviewServiceReviewDetail"

import UserServiceUserManager from "./components/listers/UserServiceUserCards"
import UserServiceUserDetail from "./components/listers/UserServiceUserDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orderServices/orders',
                name: 'OrderServiceOrderManager',
                component: OrderServiceOrderManager
            },
            {
                path: '/orderServices/orders/:id',
                name: 'OrderServiceOrderDetail',
                component: OrderServiceOrderDetail
            },

            {
                path: '/deliveryServices/deliveries',
                name: 'DeliveryServiceDeliveryManager',
                component: DeliveryServiceDeliveryManager
            },
            {
                path: '/deliveryServices/deliveries/:id',
                name: 'DeliveryServiceDeliveryDetail',
                component: DeliveryServiceDeliveryDetail
            },

            {
                path: '/productServices/products',
                name: 'ProductServiceProductManager',
                component: ProductServiceProductManager
            },
            {
                path: '/productServices/products/:id',
                name: 'ProductServiceProductDetail',
                component: ProductServiceProductDetail
            },

            {
                path: '/reviewServices/reviews',
                name: 'ReviewServiceReviewManager',
                component: ReviewServiceReviewManager
            },
            {
                path: '/reviewServices/reviews/:id',
                name: 'ReviewServiceReviewDetail',
                component: ReviewServiceReviewDetail
            },

            {
                path: '/userServices/users',
                name: 'UserServiceUserManager',
                component: UserServiceUserManager
            },
            {
                path: '/userServices/users/:id',
                name: 'UserServiceUserDetail',
                component: UserServiceUserDetail
            },



    ]
})
