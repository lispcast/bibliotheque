-- :name create-book! :! :n
-- :doc creates a new book entry
INSERT INTO books
(title, score, image_url, short_description, long_description, author, URL)
VALUES (:title, :score, :image_url, :short_description, :long_description, :author, :URL)

-- :name get-books :? :*
-- :doc retrieve all books, sorted by score
SELECT * FROM books
ORDER BY score DESC
