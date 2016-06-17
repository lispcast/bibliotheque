(ns user
  (:require [mount.core :as mount]
            bibliotheque.core))

(defn start []
  (mount/start-without #'bibliotheque.core/repl-server))

(defn stop []
  (mount/stop-except #'bibliotheque.core/repl-server))

(defn restart []
  (stop)
  (start))


