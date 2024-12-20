-- Create the 'quiz_session' table if it doesn't exist
CREATE TABLE IF NOT EXISTS quiz_session (
                                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                            user_name VARCHAR(255), -- Added user_name column
    total_questions INT,
    correct_answers INT,
    incorrect_answers INT
    );

-- Create the 'question' table if it doesn't exist
CREATE TABLE IF NOT EXISTS question (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        question_text VARCHAR(255),
    option_a VARCHAR(100),
    option_b VARCHAR(100),
    option_c VARCHAR(100),
    option_d VARCHAR(100),
    correct_answer CHAR(1)
    );

-- Insert sample data into the 'question' table
INSERT INTO question (question_text, option_a, option_b, option_c, option_d, correct_answer) VALUES
                                                                                                 ('What is the capital of France?', 'Paris', 'London', 'Berlin', 'Madrid', 'A'),
                                                                                                 ('What is 2 + 2?', '3', '4', '5', '6', 'B'),
                                                                                                 ('Which language is used for Android development?', 'Python', 'Kotlin', 'C++', 'Ruby', 'B'),
                                                                                                 ('What is the largest planet in the solar system?', 'Earth', 'Mars', 'Jupiter', 'Saturn', 'C'),
                                                                                                 ('Which programming language is used for web development?', 'JavaScript', 'C#', 'Java', 'Python', 'A');

-- Insert sample data into the 'quiz_session' table
-- Initial quiz session for testing purposes
INSERT INTO quiz_session (user_name, total_questions, correct_answers, incorrect_answers)
VALUES ('faizan', 0, 0, 0);
