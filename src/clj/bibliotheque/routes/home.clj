(ns bibliotheque.routes.home
  (:require [bibliotheque.layout :as layout]
            [bibliotheque.db.core :as db]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [ring.util.response :refer [redirect]]
            [bouncer.core :as b]
            [bouncer.validators :as v]
            [clojure.java.io :as io]))

(defn home-page [{:keys [flash]}]
  (let [books (db/get-books)]
    (layout/render
      "home.html"
      (merge {:books books}
        (select-keys flash [:errors])))))

(defn about-page []
  (layout/render "about.html"))

(defn new-page [{:keys [flash]}]
  (layout/render "new.html" flash))

(defn validate-book [params]
  (first
    (b/validate
      params
      :title [v/required v/string]
      :author [v/required v/string]
      :URL v/string
      :score [v/required]
      :image_url v/string
      :short_description v/string
      :long_description v/string)))

(defn parse-int [s]
  (try
    (Integer/parseInt s)
    (catch Throwable t
      nil)))

(defn save-book! [{:keys [params]}]
  (let [params (update params :score parse-int)]
    (if-let [errors (validate-book params)]
      (-> (response/found "/new")
        (assoc :flash (assoc params :errors errors)))
      (do
        (db/create-book! params)
        (response/found "/")))))

(defroutes home-routes
  (GET "/" request (home-page request))
  (GET "/new" request (new-page request))
  (POST "/new" request (save-book! request))
  (GET "/about" [] (about-page)))

