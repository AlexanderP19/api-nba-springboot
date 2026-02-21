async function loadStandings() {
    try {
        const response = await fetch("http://localhost:8080/api/nba");

        if (!response.ok) {
            throw new Error("Error al obtener datos");
        }

        const data = await response.json();

        // ⚠ Ajusta esto según cómo venga tu DTO
        const rawStandings  = data.result.total;

        // eliminar duplicados por nombre de equipo
        const standings = rawStandings.filter(
            (team, index, self) =>
                index === self.findIndex(t => t.standing_team === team.standing_team)
        );



        renderTables(standings);

    } catch (error) {
        console.error("Error:", error);
    }
}

function renderTables(standings) {

    const container = document.getElementById("tables-container");
    container.innerHTML = "";

    const grouped = {};

    standings.forEach(team => {
        const group = team.league_round;

        if (!grouped[group]) {
            grouped[group] = [];
        }

        grouped[group].push(team);
    });

    Object.keys(grouped).forEach(group => {

        // Ordenar por posición
        grouped[group].sort((a, b) => a.standing_place - b.standing_place);

        const groupTitle = document.createElement("h2");
        groupTitle.className = "group-title";
        groupTitle.textContent = group;

        container.appendChild(groupTitle);

        const table = document.createElement("table");

        table.innerHTML = `
            <thead>
                <tr>
                    <th>#</th>
                    <th>Team</th>
                    <th>P</th>
                    <th>W</th>
                    <th>L</th>
                    <th>PF</th>
                    <th>PA</th>
                </tr>
            </thead>
            <tbody>
                ${grouped[group].map(team => `
                    <tr class="${team.standing_place <= 2 ? 'top-team' : ''}">
                        <td class="rank">${team.standing_place}</td>
                        <td>${team.standing_team}</td>
                        <td>${team.standing_P}</td>
                        <td>${team.standing_W}</td>
                        <td>${team.standing_L}</td>
                        <td>${team.standing_F}</td>
                        <td>${team.standing_A}</td>
                    </tr>
                `).join("")}
            </tbody>
        `;

        container.appendChild(table);
    });
}

loadStandings();