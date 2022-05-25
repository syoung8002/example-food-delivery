
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/OrderManager"
import PaymentManager from "./components/PaymentManager"

import StoreOrderManager from "./components/StoreOrderManager"
import MenuManager from "./components/MenuManager"

import TopFood from "./components/TopFood"
import DeliveryManager from "./components/DeliveryManager"

import NotificationLogManager from "./components/NotificationLogManager"

import OrderStatus from "./components/OrderStatus"
import PreferenceManager from "./components/PreferenceManager"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },

            {
                path: '/storeOrders',
                name: 'StoreOrderManager',
                component: StoreOrderManager
            },
            {
                path: '/menus',
                name: 'MenuManager',
                component: MenuManager
            },

            {
                path: '/topFoods',
                name: 'TopFood',
                component: TopFood
            },
            {
                path: '/deliveries',
                name: 'DeliveryManager',
                component: DeliveryManager
            },

            {
                path: '/notificationLogs',
                name: 'NotificationLogManager',
                component: NotificationLogManager
            },

            {
                path: '/orderStatuses',
                name: 'OrderStatus',
                component: OrderStatus
            },
            {
                path: '/preferences',
                name: 'PreferenceManager',
                component: PreferenceManager
            },



    ]
})
