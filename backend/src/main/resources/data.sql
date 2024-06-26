-- matches
INSERT INTO
    matches (
        tournament_id,
        first_participant_id,
        second_participant_id,
        first_participant_scores,
        second_participant_scores,
        match_date
    )
VALUES
    (
        3,
        7,
        8,
        1,
        0,
        '2023-03-01'
    ),
    (
        3,
        9,
        10,
        1,
        1,
        '2023-03-01'
    ),
    (
        3,
        7,
        9,
        2,
        0,
        '2023-03-08'
    ),
    (
        3,
        8,
        10,
        2,
        0,
        '2023-03-08'
    ),
    (
        3,
        7,
        10,
        3,
        0,
        '2023-03-15'
    ),
    (
        3,
        8,
        9,
        2,
        0,
        '2023-03-15'
    ),
    (
        2,
        3,
        4,
        NULL,
        NULL,
        '2023-04-01'
    ),
    (
        2,
        5,
        6,
        NULL,
        NULL,
        '2023-04-01'
    ),
    (
        2,
        3,
        5,
        NULL,
        NULL,
        '2023-04-08'
    ),
    (
        2,
        4,
        6,
        NULL,
        NULL,
        '2023-04-08'
    ),
    (
        2,
        3,
        6,
        NULL,
        NULL,
        '2023-04-15'
    ),
    (
        2,
        4,
        5,
        NULL,
        NULL,
        '2023-04-15'
    );

-- participants
INSERT INTO
    participants (
        user_id,
        tournament_id,
        team_id,
        participant_current_points
    )
VALUES
    (2, 1, 1, NULL),
    (3, 1, 1, NULL),
    (2, 2, NULL, 0),
    (3, 2, NULL, 0),
    (4, 2, NULL, 0),
    (5, 2, NULL, 0),
    (2, 3, NULL, 9),
    (3, 3, NULL, 6),
    (4, 3, NULL, 1),
    (5, 3, NULL, 1);

-- ranks
INSERT INTO
    ranks (tournament_id, participant_id, current_rank)
VALUES
    (1, NULL, NULL),
    (1, 1, NULL),
    (1, 2, NULL),
    (2, 3, NULL),
    (2, 4, NULL),
    (2, 5, NULL),
    (2, 6, NULL),
    (3, 8, 1),
    (3, 9, 2),
    (3, 10, 3),
    (3, 11, 3);

-- sports
INSERT INTO
    sports (sport_name)
VALUES
    ('Rocket League'),
    ('Call of Duty: Black Ops'),
    ('Fifa'),
    ('Football'),
    ('Volleyball'),
    ('Basketball'),
    ('Tennis');

-- teams
INSERT INTO
    teams (team_name, tournament_id, rank_id)
VALUES
    ('Awesome Team', 1, 1);

-- tournaments
INSERT INTO
    tournaments (
        tournament_name,
        tournament_type,
        tournament_based,
        sport_id,
        team_max_student,
        days_between_stages,
        tournament_is_archived,
        tournament_is_open,
        tournament_start_date,
        tournament_end_date
    )
VALUES
    (
        'Rocket League Elimination Team Tournament',
        'Elimination',
        'Team',
        1,
        2,
        7,
        false,
        true,
        '2023-05-01',
        '2023-05-15'
    ),
    (
        'Black Ops Round Robin Individual Tournament',
        'RoundRobin',
        'Individual',
        2,
        1,
        7,
        false,
        false,
        '2023-04-01',
        '2023-04-15'
    ),
    (
        'Fifa Round Robin Individual Tournament',
        'RoundRobin',
        'Individual',
        3,
        1,
        7,
        true,
        false,
        '2023-03-01',
        '2023-03-15'
    );

-- users
INSERT INTO
    users (
        user_name,
        user_role,
        user_email,
        user_password_hash
    )
VALUES
    (
        'Admin Name',
        'Admin',
        'admin_1@email.com',
        '58b5444cf1b6253a4317fe12daff411a78bda0a95279b1d5768ebf5ca60829e78da944e8a9160a0b6d428cb213e813525a72650dac67b88879394ff624da482f'
    ),
    (
        'Reda Al Sulais',
        'Student',
        's202163910@kfupm.edu.sa',
        'fe627eeced3bcd4bf40e759c1511e2d4d48065d7b0280af938d816cfae8cb8f7de51477b6225cbd9284e777b7c886e096918f8d81b40379fe06a07531ed632c2'
    ),
    (
        'Hussain Alsayhah',
        'Student',
        's202028180@kfupm.edu.sa',
        '7ab0d840335ba0a0ce98674463fcc285ded7a53ed7b43e0f7cebf10b67db1bfb660f4f8c877838fc67f0be8531ad1aa5d792a33bb832728c448840eecd4b651a'
    ),
    (
        'Mahdi Alyousef',
        'Student',
        's202166410@kfupm.edu.sa',
        'f199285f06d7dd8c38862266a825f52699183bd922e6773042a5e34b4ec947859740de6042ff36feaa452fcda8d855413c69417ca087dc6bb6cd0072cee7b24b'
    ),
    (
        'Feras Alhazmi',
        'Student',
        's202031280@kfupm.edu.sa',
        '0bc29c7f14d19cc04a2c564ad8289288d4df933dcbaf1433730030cb1dbca746e323608a9995cd5204084872fcc023a238ccbbdbecf64dc59dfc95003404c83f'
    ),
    (
        'Ahmed Alahmed',
        'Student',
        'student_6@gmail.com',
        '6b779ef315da3031bad8099787b818f0f4167196e2e7d4bbcb87069e7a50a31203437cae0da29b08dc5585d1e9178d0d3efb6ca67dcef5ef82e4e4c65f738dc6'
    ),
    (
        'Student1',
        'Student',
        '202000001@kfupm.edu.sa',
        'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413'
    ),
    (
        'Student2',
        'Student',
        '202000002@kfupm.edu.sa',
        'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413'
    ),
    (
        'Student3',
        'Student',
        '202000003@kfupm.edu.sa',
        'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413'
    ),
    (
        'Student4',
        'Student',
        '202000004@kfupm.edu.sa',
        'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413'
    ),
    (
        'Student5',
        'Student',
        '202000005@kfupm.edu.sa',
        'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413'
    ),
    (
        'Student6',
        'Student',
        '202000006@kfupm.edu.sa',
        'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413'
    ),
    (
        'Student7',
        'Student',
        '202000007@kfupm.edu.sa',
        'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413'
    ),
    (
        'Student8',
        'Student',
        '202000008@kfupm.edu.sa',
        'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413'
    ),
    (
        'Student9',
        'Student',
        '202000009@kfupm.edu.sa',
        'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413'
    ),
    (
        'Student10',
        'Student',
        '202000010@kfupm.edu.sa',
        'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413'
    ),
    (
        'Student11',
        'Student',
        '202000011@kfupm.edu.sa',
        'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413'
    ),
    (
        'Student12',
        'Student',
        '202000012@kfupm.edu.sa',
        'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413'
    ),
    (
        'Student13',
        'Student',
        '202000013@kfupm.edu.sa',
        'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413'
    ),
    (
        'Student14',
        'Student',
        '202000014@kfupm.edu.sa',
        'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413'
    ),
    (
        'Student15',
        'Student',
        '202000015@kfupm.edu.sa',
        'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413'
    ),
    (
        'Student16',
        'Student',
        '202000016@kfupm.edu.sa',
        'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413'
    );
