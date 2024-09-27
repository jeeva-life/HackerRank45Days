def bfs(n, m, edges, s):
    # Write your code here
    # Step 1: Build adjacency list for the graph
    adj = [[] for _ in range(n + 1)]
    for u, v in edges:
        adj[u].append(v)
        adj[v].append(u)
    
    # Step 2: Initialize distance array with -1 (unreachable)
    distance = [-1] * (n + 1)
    distance[s] = 0  # Distance to the start node is 0
    
    # Step 3: BFS using a queue
    queue = deque([s])
    
    while queue:
        current = queue.popleft()
        
        # Explore all neighbors of the current node
        for neighbor in adj[current]:
            if distance[neighbor] == -1:  # If the neighbor hasn't been visited
                distance[neighbor] = distance[current] + 6
                queue.append(neighbor)
    
    # Step 4: Prepare the result (skip the distance of the start node)
    result = []
    for i in range(1, n + 1):
        if i != s:
            result.append(distance[i])
    
    return result