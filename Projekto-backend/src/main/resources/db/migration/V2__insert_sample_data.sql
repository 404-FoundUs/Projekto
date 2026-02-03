------------------------------------------------------------
-- SAMPLE DATA MIGRATION FOR PROJEKTO (TRELLO CLONE)
-- Flyway Migration Script
-- PostgreSQL Compatible
------------------------------------------------------------

-- ============================
-- 1. USERS
-- ============================

INSERT INTO users (id, username, email, password, first_name, last_name, is_active, created_at)
VALUES
    (
        gen_random_uuid(),
        'admin',
        'admin@projekto.com',
        '$2a$10$dummyhashedpassword',
        'Admin',
        'User',
        true,
        now()
    );

-- Save user id for reference
-- We'll use subqueries instead of hardcoding UUIDs

-- ============================
-- 2. WORKSPACE
-- ============================

INSERT INTO workspace (id, name, description, visibility, owner_id, created_at)
VALUES
    (
        gen_random_uuid(),
        'Projekto Workspace',
        'Main demo workspace',
        'PUBLIC',
        (SELECT id FROM users WHERE username='admin'),
        now()
    );

-- ============================
-- 3. BOARD
-- ============================

INSERT INTO board (id, name, description, visibility, workspace_id, created_by, created_at)
VALUES
    (
        gen_random_uuid(),
        'Demo Project Board',
        'Board for testing cards and lists',
        'PUBLIC',
        (SELECT id FROM workspace WHERE name='Projekto Workspace'),
        (SELECT id FROM users WHERE username='admin'),
        now()
    );

-- ============================
-- 4. LISTS (Columns)
-- ============================

INSERT INTO lists (id, title, position, board_id, create_at)
VALUES
    (
        gen_random_uuid(),
        'To Do',
        1,
        (SELECT id FROM board WHERE name='Demo Project Board'),
        now()
    ),
    (
        gen_random_uuid(),
        'In Progress',
        2,
        (SELECT id FROM board WHERE name='Demo Project Board'),
        now()
    ),
    (
        gen_random_uuid(),
        'Done',
        3,
        (SELECT id FROM board WHERE name='Demo Project Board'),
        now()
    );

-- ============================
-- 5. LABELS
-- ============================

INSERT INTO labels (id, name, color, board_id)
VALUES
    (
        gen_random_uuid(),
        'Backend',
        '#FF0000',
        (SELECT id FROM board WHERE name='Demo Project Board')
    ),
    (
        gen_random_uuid(),
        'Frontend',
        '#0000FF',
        (SELECT id FROM board WHERE name='Demo Project Board')
    ),
    (
        gen_random_uuid(),
        'Urgent',
        '#FFA500',
        (SELECT id FROM board WHERE name='Demo Project Board')
    );

-- ============================
-- 6. CARDS
-- ============================

INSERT INTO cards (id, title, description, position, due_date, priority, list_id, board_id, create_at)
VALUES
    (
        gen_random_uuid(),
        'Setup Spring Boot Project',
        'Initialize backend project structure',
        1,
        now() + interval '7 days',
        'HIGH',
        (SELECT id FROM lists WHERE title='To Do'),
        (SELECT id FROM board WHERE name='Demo Project Board'),
        now()
    ),
    (
        gen_random_uuid(),
        'Build Angular UI',
        'Create frontend workspace dashboard',
        1,
        now() + interval '10 days',
        'MEDIUM',
        (SELECT id FROM lists WHERE title='In Progress'),
        (SELECT id FROM board WHERE name='Demo Project Board'),
        now()
    );

-- ============================
-- 7. CARD_LABELS (Many-to-Many)
-- ============================

INSERT INTO card_labels (card_id, label_id)
VALUES
    (
        (SELECT id FROM cards WHERE title='Setup Spring Boot Project'),
        (SELECT id FROM labels WHERE name='Backend')
    ),
    (
        (SELECT id FROM cards WHERE title='Build Angular UI'),
        (SELECT id FROM labels WHERE name='Frontend')
    ),
    (
        (SELECT id FROM cards WHERE title='Setup Spring Boot Project'),
        (SELECT id FROM labels WHERE name='Urgent')
    );

-- ============================
-- 8. CHECKLIST
-- ============================

INSERT INTO checklists (id, title, position, card_id)
VALUES
    (
        gen_random_uuid(),
        'Backend Setup Checklist',
        1,
        (SELECT id FROM cards WHERE title='Setup Spring Boot Project')
    );

-- ============================
-- 9. CHECKLIST ITEMS
-- ============================

INSERT INTO checklist_items (id, content, is_completed, position, checklist_id)
VALUES
    (
        gen_random_uuid(),
        'Create Entities',
        true,
        1,
        (SELECT id FROM checklists WHERE title='Backend Setup Checklist')
    ),
    (
        gen_random_uuid(),
        'Create Repositories',
        false,
        2,
        (SELECT id FROM checklists WHERE title='Backend Setup Checklist')
    ),
    (
        gen_random_uuid(),
        'Add Flyway Migration',
        false,
        3,
        (SELECT id FROM checklists WHERE title='Backend Setup Checklist')
    );

-- ============================
-- 10. COMMENTS
-- ============================

INSERT INTO comment (id, content, card_id, user_id, created_at)
VALUES
    (
        gen_random_uuid(),
        'Started working on backend structure.',
        (SELECT id FROM cards WHERE title='Setup Spring Boot Project'),
        (SELECT id FROM users WHERE username='admin'),
        now()
    );

------------------------------------------------------------
-- END SAMPLE DATA MIGRATION
------------------------------------------------------------
