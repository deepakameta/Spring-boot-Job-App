INSERT INTO job (name, description)
VALUES ('Java Developer', 'Backend developer with Spring Boot'),
       ('Frontend Developer', 'React.js and UI expert'),
       ('Android Developer', 'Jetpack Compose and Kotlin expert'),
       ('iOS Developer', 'Swift and UIKit professional'),
       ('DevOps Engineer', 'CI/CD pipelines and Docker/Kubernetes'),
       ('Data Scientist', 'Machine Learning and Data Analysis'),
       ('QA Engineer', 'Automated and Manual testing expert'),
       ('Full Stack Developer', 'Java + Angular full stack development'),
       ('Product Manager', 'Roadmap planning and stakeholder communication'),
       ('UI/UX Designer', 'Figma, user flows, and visual design expert');


INSERT INTO company (name, address)
VALUES ('Google', '1600 Amphitheatre Parkway, Mountain View, CA'),
       ('Microsoft', '1 Microsoft Way, Redmond, WA'),
       ('Amazon', '410 Terry Ave N, Seattle, WA'),
       ('Facebook', '1 Hacker Way, Menlo Park, CA'),
       ('Netflix', '100 Winchester Circle, Los Gatos, CA');


INSERT INTO review (company_id, content, rating)
VALUES (1, 'Normal job description', 5),
       (1, 'Great work-life balance', 4),
       (2, 'Flexible hours and remote work', 5),
       (2, 'Good pay but long hours', 3),
       (3, 'Supportive team environment', 4),
       (3, 'Slow growth but decent benefits', 3),
       (4, 'Amazing perks and campus', 5),
       (5, 'Innovative and fast-paced', 5),
       (5, 'Stressful deadlines', 2),
       (1, 'Amazing engineering culture', 5);
